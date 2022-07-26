package src.chapter1_stackandqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem_04_CatDogQueue {
    public static class Pet{
        private String type;

        public Pet(String type){
            this.type = type;
        }

        public String getType(){
            return this.type;
        }
    }
    public static class Dog extends Pet{
        public String type;
        public Dog(){
            super("Dog");
        }
    }
    public static class Cat extends Pet{
        public Cat(){
            super("Cat");
        }
    }
    public static class PetEnterQueue{
        private Pet pet;
        private long count;

        public PetEnterQueue(Pet pet,long count){
            this.pet = pet;
            this.count = count;
        }
        public Pet getPet(){
            return this.pet;
        }
        public long getCount(){
            return this.count;
        }
        public String getEnterPetType(){
            return this.pet.getType();
        }
    }
    public static class DogCatQueue{
        private Queue<PetEnterQueue> dogQ;
        private Queue<PetEnterQueue> catQ;
        private long count;

        public DogCatQueue(){
            this.dogQ = new LinkedList<PetEnterQueue>();
            this.catQ = new LinkedList<PetEnterQueue>();
            this.count = 0;
        }

        public void add(Pet pet){
            if("Dog".equals(pet.getType())){
                this.dogQ.add(new PetEnterQueue(pet,this.count++));
            }else if ("Cat".equals(pet.getType())){
                this.catQ.add(new PetEnterQueue(pet,this.count++));
            }else{
                throw new RuntimeException("error,not dog or cat");
            }
        }
        public Pet pollAll(){
            if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()){
                if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()){
                    return this.dogQ.poll().getPet();
                }else{
                    return this.catQ.poll().getPet();
                }
            }else if (!this.dogQ.isEmpty()){
                return this.dogQ.poll().getPet();
            }else if (!this.catQ.isEmpty()){
                return this.catQ.poll().getPet();
            }else {
                throw new RuntimeException("error,queue is empty");
            }
        }
        public Pet pollDog(){
            if (!this.dogQ.isEmpty()) {
                return (Dog) this.dogQ.poll().getPet();
            }else {
                throw new RuntimeException("error,queue is empty");
            }
        }
        public Pet pollCat(){
            if (!this.catQ.isEmpty()){
                return (Cat)this.catQ.poll().getPet();
            }else {
                throw new RuntimeException("error,queue is empty");
            }
        }
        public boolean isEmpty(){
            return this.dogQ.isEmpty() && this.catQ.isEmpty();
        }
        public boolean isDogQueueEmpty(){
            return this.dogQ.isEmpty();
        }
        public boolean isCatQueueEmpty(){
            return this.catQ.isEmpty();
        }

    }

    public static void main(String[] args) {
        DogCatQueue test = new DogCatQueue();
        Dog dog1 = new Dog();
        Cat cat1 = new Cat();
        Dog dog2 = new Dog();
        Cat cat2 = new Cat();
        Dog dog3 = new Dog();
        Cat cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        System.out.println("=========");
        System.out.println(test.isEmpty());
        while (!test.isEmpty()){
            System.out.println(test.pollAll().getType());
        }
        System.out.println(test.isEmpty());
        System.out.println("=========");
        while (!test.isDogQueueEmpty()){
            System.out.println(test.pollDog().getType());
        }
        System.out.println("=========");
        while (!test.isCatQueueEmpty()){
            System.out.println(test.pollCat().getType());
        }
    }
}

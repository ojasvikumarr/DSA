class Day288 {

    public int maximumLength(int[] nums) {
        int res = 0;
        int[][] patterns = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
        for (int[] pattern : patterns) {
            int cnt = 0;
            for (int num : nums) {
                if (num % 2 == pattern[cnt % 2]) {
                    cnt++;
                }
            }
            res = Math.max(res, cnt);
        }
        // ??Hello
        return res;
    }

    class Animal{
        int data ; 
        private Animal(int data){
            this.data = data ;
        }
        public static Animal getInstance(int data){
            if(data == 0){
                System.out.println("Sorry no object created");
                return ; 
            }else{
                Animal a = new Animal(data);
                return a ; 
            }
        }
    }

    // Decoupling
    interface Animal{
        abstract void makeSound(); // Abstarct method , method without implementation
        //Standardisation
        abstract void sleeping(){ // concrete method , method with implementation 
            System.out.println("Zzz...");
        }
    }

    // complexity increase because you need to see way up 
    class Dog implements Animal{
        @Override
        void makeSound(){
            System.out.println("Woof Woof!!");
        }
    }
    class Cat implements Animal{
        @Override 
        public void makeSound(){
            System.out.println("Meow Meow!!");
        }
    }
    abstract class Node{
        int data ; 
        //astract method for specific behaviour that is common among all 
        abstract void makeSound();
        //concrete method for shared behavior 
        public void sleeping(){
            System.out.println("Zzz..");
        }
    }
    class tree extends Node{
        @Override
        void makeSound(){
            System.out.println("Vroom Vroom!!");
        }
    }
}
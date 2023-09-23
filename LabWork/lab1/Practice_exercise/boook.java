package lab1.Practice_exercise;

import java.util.ArrayList;

public class boook {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("ABC", 100));
        books.add(new Book("Whispers of the Wind", 200));
        books.add(new Textbook("Advanced Calculus", 208, "ICS-203"));
        books.add(new Textbook("Modern Physics", 183, "ICS-204"));
        books.add(new Textbook("Organic Chemistry", 212, "ICS-205"));
        books.add(new Book("Shadows in Time", 244));
        books.add(new Book("The Silent Oath", 104));
        books.add(new Book("Echoes of Destiny", 157));
        books.add(new Textbook("Data Structures", 100, "ICS-202"));
        books.add(new Book("Beneath the Crimson Sky", 287));

        int numberOfBooks = 0;
        int numberOfTextBooks = 0;

        for (Book book : books) {
            if (book instanceof Textbook) {
                numberOfTextBooks++;
            } else {
                numberOfBooks++;
            }
            System.out.println(book);
        }
        System.out.println("Number of Books = " + numberOfBooks);
        System.out.println("Number of TextBooks = " + numberOfTextBooks);
    }
    }
     class Book {
        private String title;
        private int pages;

        public Book(String title,int pages){
            this.title =title;
            this.pages = pages;
        }



        public String getTitle(){
            return title;
        }
        public int getPages(){
            return pages;
        }

        public void setTitle(String title){
            this.title = title;
        }
        public void setPages(int pages){
            this.pages = pages;
        }

        public String toString(){
            return "Book: "+ title+", # Pages = "+ pages;
        }


    }


      class Textbook extends Book {
        private String course;

        public Textbook(String title, int pages,String course) {
            super(title, pages);
            this.course = course;
        }

          public String getCourse(){
              return course;
          }
          public void setCourse(String course){
              this.course = course;
          }



        public String toString(){
            return "Text Book: "+super.getTitle()+ ", " +course+ ", # Pages = "+getPages()+", Course = "+course;
        }
    }



//package com.example.libraryapp.component;
//
//import com.example.libraryapp.entity.Address;
//import com.example.libraryapp.entity.Category;
//import com.example.libraryapp.entity.Library;
//import com.example.libraryapp.repository.AddressRepository;
//import com.example.libraryapp.repository.BookRepository;
//import com.example.libraryapp.repository.CategoryRepository;
//import com.example.libraryapp.repository.LibraryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Dataloader implements CommandLineRunner {
//
//    @Value("${spring.sql.init.mode}")
//    private String mode;
//    @Value("${spring.jpa.hibernate.ddl-auto}")
//    private String ddl;
//
//    @Autowired
//    BookRepository bookRepository;
//    @Autowired
//    LibraryRepository libraryRepository;
//    @Autowired
//    CategoryRepository categoryRepository;
//    @Autowired
//    AddressRepository addressRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        if (ddl.equals("create") && mode.equals("always")) {
//            System.out.println("Ishladi");
//            Category category = new Category("Jahon");
//            Category category1 = new Category("Ozbek");
//            Category category2 = new Category("Drama");
//            categoryRepository.save(category);
//            categoryRepository.save(category1);
//            categoryRepository.save(category2);
//
//            Address address = new Address("10", "Toshkent", "Shodlik");
//            Address save = addressRepository.save(address);
//            Library library = new Library("Navoiy", save);
//            libraryRepository.save(library);
//        }
//    }
//
//}

package com.scanbuyTest.Scanbuydemo.Service.impl;

import org.springframework.stereotype.Service;
import com.scanbuyTest.Scanbuydemo.Repository.UserRepository;
import com.scanbuyTest.Scanbuydemo.Service.UserBookDetailsService;
import com.scanbuyTest.Scanbuydemo.Repository.BookRepository;
import com.scanbuyTest.Scanbuydemo.Repository.UserBookDetailsRepository;
import com.scanbuyTest.Scanbuydemo.model.Book;
import com.scanbuyTest.Scanbuydemo.model.User;
import com.scanbuyTest.Scanbuydemo.model.UserBookDetails;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

@Service
public class UserBookDetailsServiceImpl implements UserBookDetailsService {

    BookRepository bookrepo;
    UserRepository userrepo;

    UserBookDetailsRepository userbookdetailrepo;

    public UserBookDetailsServiceImpl(UserBookDetailsRepository userbookdetailrepo, BookRepository bookrepo,
            UserRepository userrepo) {
        this.userbookdetailrepo = userbookdetailrepo;
        this.bookrepo = bookrepo;
        this.userrepo = userrepo;
    }

    // The functionality will return all books of the particular user

    public ResponseEntity<Object> userBooks(String email) {

        User user = userrepo.email(email);

        ArrayList<UserBookDetails> us = userbookdetailrepo.findAllBooksUser(user);
        Map<String, Object> hm = new HashMap<>();
        hm.put("response", us);
        hm.put("status", 200);
        HttpStatus httpStatus = HttpStatus.OK;
        return new ResponseEntity<>(hm, httpStatus);

    }

    // The functionality is used to check wether the particular book is present in
    // the
    // user database
    public ResponseEntity<Object> userBook(String email, String ISBN) {

        Book bk = bookrepo.ISBN((ISBN));
        User user = userrepo.email(email);

        UserBookDetails us = userbookdetailrepo.findUserBookDetails(user, bk);

        if (us == null) {
            Map<String, Object> hm = new HashMap<>();
            hm.put("bookstatus", false);
            hm.put("BookDetails", bk);
            hm.put("status", 200);
            HttpStatus httpStatus = HttpStatus.OK;
            return new ResponseEntity<>(hm, httpStatus);

        } else {
            Map<String, Object> hm = new HashMap<>();
            hm.put("bookstatus", true);
            hm.put("BookDetails", bk);
            hm.put("BookNotes", us.getNotes());
            hm.put("BookFinished", us.getFinished());
            hm.put("status", 200);
            HttpStatus httpStatus = HttpStatus.OK;
            return new ResponseEntity<>(hm, httpStatus);
        }
    }

    // The dunctionlaity is used to update or add the notes to a paritcular book by
    // user
    // individually
    public ResponseEntity<Object> userBookNotes(Map<String, String> body) {

        System.out.println("body" + body);
        Book bk = bookrepo.ISBN((body.get("ISBN")));
        User user = userrepo.email(body.get("email"));

        UserBookDetails us = userbookdetailrepo.findUserBookDetails(user, bk);
        us.setNotes(body.get("notes"));
        userbookdetailrepo.save(us);
        UserBookDetails us1 = userbookdetailrepo.findUserBookDetails(user, bk);
        Map<String, Object> hm = new HashMap<>();
        hm.put("response", us1);
        hm.put("status", 200);
        HttpStatus httpStatus = HttpStatus.OK;
        return new ResponseEntity<>(hm, httpStatus);
    }

    // The functionality is used to make a book as a Read or Not read using the
    // boolean
    public ResponseEntity<Object> userBookRead(Map<String, String> body) {
        Book bk = bookrepo.ISBN((body.get("ISBN")));
        User user = userrepo.email(body.get("email"));
        UserBookDetails us = userbookdetailrepo.findUserBookDetails(user, bk);
        us.setFinished(Boolean.parseBoolean(body.get("finished")));
        userbookdetailrepo.save(us);
        UserBookDetails us1 = userbookdetailrepo.findUserBookDetails(user, bk);
        Map<String, Object> hm = new HashMap<>();
        hm.put("response", us1);
        hm.put("status", 200);
        HttpStatus httpStatus = HttpStatus.OK;
        return new ResponseEntity<>(hm, httpStatus);

    }

    // The functionality is used to delete a book from the user database
    @Transactional
    public ResponseEntity<Object> userBookDelete(Map<String, String> body) {
        System.out.println("deletebook" + body);
        Book bk = bookrepo.ISBN((body.get("ISBN")));
        User user = userrepo.email(body.get("email"));
        UserBookDetails us = userbookdetailrepo.findUserBookDetails(user, bk);
        // UserBookDetails usb = userbookdetailrepo.id(us.getId());
        userbookdetailrepo.deleteByid(us.getId());
        Map<String, Object> hm = new HashMap<>();
        hm.put("response", "book deleted");
        hm.put("status", 200);
        HttpStatus httpStatus = HttpStatus.OK;
        return new ResponseEntity<>(hm, httpStatus);
    }
    // The functionality is used to add a book to the user inventory if the book is
    // not present in the user inventory

    public ResponseEntity<Object> userBookAdd(Map<String, String> body) {

        Book bk = bookrepo.ISBN((body.get("ISBN")));
        User user = userrepo.email(body.get("email"));

        UserBookDetails us = userbookdetailrepo.findUserBookDetails(user, bk);

        if (us == null) {
            us = new UserBookDetails();
            us.setBook(bk);
            us.setUser(user);
            us.setNotes(body.get("notes"));
            us.setFinished(false);
        }

        userbookdetailrepo.save(us);
        UserBookDetails us1 = userbookdetailrepo.findUserBookDetails(user, bk);
        Map<String, Object> hm = new HashMap<>();
        hm.put("response", us1);
        hm.put("status", 200);
        HttpStatus httpStatus = HttpStatus.OK;
        return new ResponseEntity<>(hm, httpStatus);
    }

}

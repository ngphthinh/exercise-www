package iuh.fit.se.demotrgh.service;

import iuh.fit.se.demotrgh.model.Book;
import iuh.fit.se.demotrgh.model.CartItem;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Cart implements Serializable {
    private List<CartItem> bookList = new ArrayList<>();

    public void addToCard(CartItem cartItem) {

        if (bookList.stream().filter(e ->
                        e.getBook().getId().equals(cartItem.getBook().getId()))
                .findFirst()
                .orElse(null) == null) {
            bookList.add(cartItem);
            return;
        }

        for (CartItem c : bookList) {
            if (c.getBook().getId().equals(cartItem.getBook().getId())) {
                c.setQuantity(c.getQuantity() + 1);
                break;
            }
        }
    }

    public void remove(String bookId) {
        bookList.removeIf(e -> e.getBook().getId().equals(bookId));
    }


    public void clear() {
        bookList.clear();
    }
}

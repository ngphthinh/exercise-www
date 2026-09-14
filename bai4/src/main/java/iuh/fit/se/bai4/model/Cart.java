package iuh.fit.se.bai4.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Cart {
    private final List<CartItem> items;


    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Book book) {
        for (CartItem cartItem : items) {
            if (cartItem.getBook().getBookId().equals(book.getBookId())) {
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                return;
            }
        }
        items.add(CartItem.builder().book(book).quantity(1).build());
    }

    public void removeItem(String bookId) {
        items.removeIf(cartItem -> cartItem.getBook().getBookId().equals(bookId));
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(item -> item.getBook().getPrice() * item.getQuantity()).sum();
    }

    public void clear() {
        items.clear();
    }


}



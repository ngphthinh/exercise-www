package org.ngphthinh.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


public class CartBean {
    @Getter
    private final List<CartItemBean> items;

    public CartBean() {
        items = new ArrayList<>();
    }

    public void addProduct(Product product) {
        items.stream().filter(p ->
                        p.getProduct().getId() == product.getId())
                .findFirst()
                .ifPresentOrElse(
                        e ->
                                e.setQuantity(e.getQuantity() + product.getQuantity()),
                        () -> items.add(CartItemBean.builder().product(product).quantity(1).build())
                );
    }

    public void removeProduct(int productId) {
        items.removeIf(p -> p.getProduct().getId() == productId);
    }

    public void updateQuantity(int productId, int quantity) {
        items.stream().filter(p -> p.getProduct().getId() == productId)
                .findFirst()
                .ifPresent(e -> {
                            if (quantity > 0) {
                                e.setQuantity(quantity);
                            } else {
                                removeProduct(productId);
                            }
                        }
                );
    }

    public double getTotal() {
        return items.stream().mapToDouble(CartItemBean::getSubTotal).sum();
    }
    public void clear() {
        items.clear();
    }
}

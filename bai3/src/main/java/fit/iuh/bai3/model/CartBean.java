package fit.iuh.bai3.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class CartBean {
    @Getter
    private List<CartItemBean> cartItemBeans = new ArrayList<>();

    public void addToCart(Product product){
        for(CartItemBean c: cartItemBeans){
            if (c.getProduct().getId()== product.getId()){
                c.setQuantity(c.getQuantity() +1);
                return;
            }
        }

        cartItemBeans.add(new CartItemBean(product, 1));
    }

    public void remove(int id){
        cartItemBeans.removeIf(e->e.getProduct().getId() == id);
    }

    public void updateQuantity(int productId, int quantity ){
        for (CartItemBean c: cartItemBeans){
            if (c.getProduct().getId()== productId){
                if (quantity <0) {
                    remove(productId);
                }else {
                    c.setQuantity(quantity);
                }
            }
            return;
        }
    }



    public double getTotal () {
        return cartItemBeans.stream().mapToDouble(CartItemBean::subTotal).sum();
    }

    public void clear (){
        cartItemBeans.clear();
    }

}

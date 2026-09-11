package fit.iuh.bai3.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CartItemBean
{
    private Product product;
    private int quantity;

    public double subTotal(){
        return product.getPrice() * quantity;
    }
}

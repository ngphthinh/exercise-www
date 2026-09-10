package org.ngphthinh.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CartItemBean {
    private Product product;
    private int quantity;

    public double getSubTotal() {
        return product.getPrice() * quantity;
    }
}

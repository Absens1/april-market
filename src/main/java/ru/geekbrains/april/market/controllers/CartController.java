package ru.geekbrains.april.market.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.april.market.dtos.StringResponse;
import ru.geekbrains.april.market.services.CartService;
import ru.geekbrains.april.market.utils.Cart;

import java.security.Principal;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
@Slf4j
public class CartController {
    private final CartService cartService;

    @GetMapping("/generate")
    public StringResponse getNewCartId() {
        String uuid = null;
        do {
            uuid = UUID.randomUUID().toString();
        } while (cartService.isCartExists(uuid));
        return new StringResponse(uuid);
    }

    @GetMapping("/merge")
    public void mergeCarts(Principal principal, @RequestParam String cartId) {
        cartService.merge(principal.getName(), cartId);
    }

    @GetMapping("/add")
    public void addToCart(Principal principal, @RequestParam(name = "prodId") Long id, @RequestParam String cartName) {
        if (principal != null) {
            cartName = principal.getName();
        }
        cartService.addToCart(cartName, id);
    }

    @GetMapping("/dec")
    public void decrementProduct(Principal principal, @RequestParam(name = "prodId") Long id, @RequestParam String cartName) {
        if (principal != null) {
            cartName = principal.getName();
        }
        cartService.decrementProduct(cartName, id);
    }

    @GetMapping("/clear")
    public void clearCart(Principal principal, @RequestParam String cartName) {
        if (principal != null) {
            cartName = principal.getName();
        }
        cartService.clearCart(cartName);
    }

    @GetMapping
    public Cart getCart(Principal principal, @RequestParam String cartName) {
        if (principal != null) {
            cartName = principal.getName();
        }
        return cartService.getCurrentCart(cartName);
    }
}

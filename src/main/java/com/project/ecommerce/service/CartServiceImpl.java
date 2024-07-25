package com.project.ecommerce.service;


import com.project.ecommerce.entity.Cart;
import com.project.ecommerce.entity.Product;
import com.project.ecommerce.repository.CartRepository;
import com.project.ecommerce.repository.CustomerRepository;
import com.project.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public void updateCart(Cart cart) {
        // Sepetin toplam fiyatını yeniden hesapla
        double totalPrice = cart.getProducts().stream()
                .mapToDouble(Product::getPrice)
                .sum();
        cart.setTotalPrice(totalPrice);

        // Sepeti veritabanında güncelle
        cartRepository.save(cart);
    }

    @Override
    public Cart getCart(Long customerId) {
        // Müşterinin sepetini müşteri ID'sine göre bul
        return cartRepository.findByCustomer_Id(customerId)
                .orElseThrow(() -> new RuntimeException("Sepet bulunamadı"));
    }

    @Override
    public void emptyCart(Long customerId) {
        // Müşterinin sepetini al
        Cart cart = getCart(customerId);

        // Sepetteki ürünleri temizle
        cart.getProducts().clear();

        // Sepetin toplam fiyatını sıfırla
        cart.setTotalPrice(0);

        // Sepeti veritabanında güncelle
        cartRepository.save(cart);
    }

    @Override
    public void AddProductToCart(Long customerId, Long productId, int quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException("Geçersiz miktar: Miktar 0 veya daha az olamaz");
        }

        // Müşterinin sepetini ve ürünü al
        Cart cart = getCart(customerId);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı"));

        // Stok kontrolü yap
        if (product.getStock() < quantity) {
            throw new RuntimeException("Stokta yeterli ürün yok. Mevcut stok: " + product.getStock());
        }

        // Ürünü istenilen adette sepete ekle
        for (int i = 0; i < quantity; i++) {
            cart.getProducts().add(product);
        }

        //populate, converter, dto productdata

        // Sepetin toplam fiyatını yeniden hesapla
        double totalPrice = cart.getProducts().stream()
                .mapToDouble(Product::getPrice)
                .sum();
        cart.setTotalPrice(totalPrice);

        // Sepeti veritabanında güncelle
        cartRepository.save(cart);
        ;
    }

    @Override
    public void RemoveProductFromCart(Long customerId, Long productId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Geçersiz miktar: Miktar 0 veya daha az olamaz");
        }

        // Müşterinin sepetini ve ürünü al
        Cart cart = getCart(customerId);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı"));

        // Sepetteki ürünlerin miktarını hesapla
        long productCountInCart = cart.getProducts().stream()
                .filter(p -> p.equals(product))
                .count();

        // Ürün miktarını kontrol et
        if (productCountInCart < quantity) {
            throw new RuntimeException("Sepette yeterli ürün yok. Mevcut miktar: " + productCountInCart);
        }

        // Ürünü sepette belirtilen adette çıkar
        for (int i = 0; i < quantity; i++) {
            cart.getProducts().remove(product);
        }

        // Sepetin toplam fiyatını yeniden hesapla
        double totalPrice = cart.getProducts().stream()
                .mapToDouble(Product::getPrice)
                .sum();
        cart.setTotalPrice(totalPrice);

        // Sepeti veritabanında güncelle
        cartRepository.save(cart);
    }

}

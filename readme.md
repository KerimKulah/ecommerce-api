# E-commerce API

Bu proje, bir e-ticaret platformu için gerekli temel API uç noktalarını sağlayan bir uygulamadır. Kullanıcılar, sepetlerini yönetebilir, ürünleri ekleyip kaldırabilir, sipariş verebilir ve fiyat geçmişini görüntüleyebilirler.

## İçindekiler
- [Kurulum](#kurulum)
- [Kullanım](#kullanım)
  - [Sepet Yönetimi](#sepet-yönetimi)
  - [Müşteri Yönetimi](#m%C3%BC%C5%9Fteri-y%C3%B6netimi)
  - [Sipariş Yönetimi](#sipari%C5%9F-y%C3%B6netimi)
  - [Fiyat Geçmişi](#fiyat-ge%C3%A7mi%C5%9Fi)
  - [Ürün Yönetimi](#%C3%BCr%C3%BCn-y%C3%B6netimi)
- [Teknolojiler](#teknolojiler)

## Kurulum

1. Projeyi klonlayın:
   ```bash
   git clone https://github.com/kullanici_adi/proje_adi.git
   cd proje_adi
   ```

2. Gerekli bağımlılıkları yükleyin:
   ```bash
   mvn install
   ```

3. Uygulamayı başlatın:
   ```bash
   mvn spring-boot:run
   ```

## Kullanım

### Sepet Yönetimi

- **Sepeti Güncelle**
  - **Yöntem:** `PUT /carts/update`
  - **Body:** Cart nesnesi
  - **Yanıt:** `"success"`

- **Sepeti Getir**
  - **Yöntem:** `GET /carts/{id}`
  - **Yanıt:** Cart nesnesi

- **Sepeti Boşalt**
  - **Yöntem:** `POST /carts/{id}/empty`
  - **Yanıt:** `"Cart is empty"`

- **Sepete Ürün Ekle**
  - **Yöntem:** `POST /carts/addProductToCart/{customerId}/{productId}/{quantity}`
  - **Yanıt:** `"success"`

- **Sepetten Ürün Kaldır**
  - **Yöntem:** `DELETE /carts/removeProductFromCart/{customerId}/{productId}/{quantity}`
  - **Yanıt:** `"success"`

### Müşteri Yönetimi

- **Müşteri Ekle**
  - **Yöntem:** `POST /customers/add`
  - **Body:** Customer nesnesi
  - **Yanıt:** `"OK"`

- **Tüm Müşterileri Getir**
  - **Yöntem:** `GET /customers/getAllCustomers`
  - **Yanıt:** List<Customer>

- **Müşteri Getir**
  - **Yöntem:** `GET /customers/{id}`
  - **Yanıt:** Customer nesnesi

### Sipariş Yönetimi

- **Sipariş Oluştur**
  - **Yöntem:** `POST /orders/placeOrder/{customerId}`
  - **Yanıt:** `"siparis olusturuldu."`

- **Siparişi Getir**
  - **Yöntem:** `GET /orders/{orderCode}`
  - **Yanıt:** Orderr nesnesi

- **Müşteri Siparişlerini Getir**
  - **Yöntem:** `GET /orders/getAllOrdersForCustomer/{customerId}`
  - **Yanıt:** List<Orderr>

### Fiyat Geçmişi

- **Fiyat Geçmişini Getir**
  - **Yöntem:** `GET /pricehistory/{code}`
  - **Yanıt:** List<PriceHistory>

### Ürün Yönetimi

- **Ürün Getir**
  - **Yöntem:** `GET /products/{id}`
  - **Yanıt:** Product nesnesi

- **Tüm Ürünleri Getir**
  - **Yöntem:** `GET /products/getAllProducts`
  - **Yanıt:** List<Product>

- **Ürün Ekle**
  - **Yöntem:** `POST /products/add`
  - **Body:** Product nesnesi
  - **Yanıt:** `"Product added"`

- **Ürün Sil**
  - **Yöntem:** `DELETE /products/delete`
  - **Body:** Product nesnesi
  - **Yanıt:** `"Product deleted"`

- **Ürünü Güncelle**
  - **Yöntem:** `POST /products/update`
  - **Body:** Product nesnesi
  - **Yanıt:** `"Product updated"`

## Teknolojiler
- Java
- Spring Boot
- Maven
- JPA
- H2 Database

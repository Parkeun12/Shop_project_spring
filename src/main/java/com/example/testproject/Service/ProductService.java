//package com.example.testproject.Service;
//
//import com.example.testproject.dto.ProductForm;
//import com.example.testproject.entity.Product;
//import com.example.testproject.repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//public class ProductService {
//
//    @Autowired
//    ProductRepository productRepository;
//
////    public List<Product> index() {
////        return articleRepository.findAll();
////    }
////
////    public Product show(Long id) {
////        return articleRepository.findById(id).orElse(null);
////    }
//
//    public Product create(ProductForm dto) {
//        Product article = dto.toEntity();
//        //POST는 데이터의 삽임임
//        //이때 body에 id값과 title, content가 같이 전송될 경우 수정(PATCH)가 일어남
//        //이를 방지하고자 BODY에 id가 같이 전송 될 경우 null이 처리되게함
//        if(article.getProductNum() != null){
//            return null;
//        }
//        return productRepository.save(article);
//    }
//
//
//}

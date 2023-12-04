package com.example.testproject.controller;

import com.example.testproject.Service.FileUploadService;
import com.example.testproject.dto.ProductForm;
import com.example.testproject.entity.Product;
import com.example.testproject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    private FileUploadService fileUploadService;

    // 상품 등록 페이지
    @GetMapping("/product/new")
    public String productSave(){
        return "articles/productNew";
    }

    // 상품 등록 (post) <pro 이름 변경 여부>
    @PostMapping("/product/create")
    public String createProduct(@ModelAttribute ProductForm form, @RequestParam("productImg") MultipartFile file){

        try {
            fileUploadService.uploadFile(file);
            // 파일 업로드 성공
        } catch (IOException e) {
            // 파일 업로드 실패
            e.printStackTrace();
        }




        log.info(form.toString());
        //1. DTO > Entity로 변환
        Product product = form.toEntity();
        log.info(product.toString());
        //2. 변환된 Entity를 Repository를 통해서 DB에 저장
        Product saved = productRepository.save(product);
        log.info(form.toString());

        return "redirect:/product/" + saved.getProductNum();
    }
    @GetMapping("/product/{productNum}")
    //ULR 요청이 오면 전달받은 id 값을 매개변수에 대응해서 넘겨줌
    public String show(@PathVariable Long productNum, Model model)
    {
        log.info("productNum = " + productNum);
        // 1. 전달받은 id 값으로 조회 > 데이터 가져오기
        Product productEntity = productRepository.findById(productNum).orElse(null);
        // 2. 모델에 데이터 등록하기
        //조회를 통해서 가져온 데이터(엔티티)를 모델에 등록하기
        //addAttribute(등록 이름, 등록 데이터)
        model.addAttribute("product", productEntity);
        // 3. 뷰 페이지 반환
        return "articles/productShow";
    }

    @GetMapping("/product")
    public String index(Model model)
    {
        //1. 디비에서 Article 테이블에 있는 모든 데이터 가져오기
        ArrayList<Product> productEntityList = productRepository.findAll();
        //Iterable, Collection, List ... 상하 관계를 지님
        //따라서 Iterable 이라는 상위 타입으로 캐스팅 해줌
        //낮 > 높 = 업캐스팅
        //높 > 낮 = 다운캐스팅

        //2. Article 묶음을 모델에 등록( Entity > Model )
        model.addAttribute("productList", productEntityList);
        //3. 뷰에 모델 뿌리기(표시)
        return "articles/productList";
    }

    //    ---------------------------------------------------------------------------
    //수정하기
    @GetMapping("/product/{productNum}/edit")
    public String edit(@PathVariable Long productNum, Model model)
    {
        //1. 수정할 데이터 가져오기
        Product productEntity = productRepository.findById(productNum).orElse(null);
        //2. 모델에 데이터 등록
        model.addAttribute("product", productEntity);

        return "articles/productEdit";
    }

    @PostMapping("/product/update")
    public String update(ProductForm form)
    {
        log.info(form.toString());
        //1. DTO > 엔티티
        Product product = form.toEntity();
        //폼에서 넘겨받은 데이터를 엔티티로 변환후에
        //해당 타겟에 대한 정보로 디비에 접근(ID로 조회)
        Product UpdateTarget = productRepository.findById(product.getProductNum()).orElse(null);
        //2. 엔티티 > 디비로
        if(UpdateTarget != null)
        {
            //수정 대상이 존재할 경우에만(null이 아닌경우) 수정 or 저장
            productRepository.save(product);
        }
        //3. 디비 저장 후에 리다이렉트
        return "redirect:/product/" + product.getProductNum();
    }

    // 특정 상품 삭제
    @GetMapping("/product/{productNum}/delete")
    public String Delete(@PathVariable Long productNum, RedirectAttributes ra){
        //삭제할 대상 가져오기
        Product DeleteTarget = productRepository.findById(productNum).orElse(null);
        //대상 엔티티 삭제
        if(DeleteTarget != null)
        {
            //삭제 대상이 존재할 경우에만(null이 아닌경우) 삭제
            productRepository.delete(DeleteTarget);
            //addFlashAttribute(키 문자열, 값 문자)
            ra.addFlashAttribute("msg", "Delete Complete");
        }
        // 결과화면 리다이렉트
        return "redirect:/product";
    }


}
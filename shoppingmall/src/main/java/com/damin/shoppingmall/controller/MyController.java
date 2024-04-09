package com.damin.shoppingmall.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.damin.shoppingmall.model.Member;
import com.damin.shoppingmall.model.Orders;
import com.damin.shoppingmall.model.Product;
import com.damin.shoppingmall.repository.MemberMapper;
import com.damin.shoppingmall.service.LoginService;
import com.damin.shoppingmall.service.OrderService;
import com.damin.shoppingmall.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MyController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	MemberMapper memberMapper;
	
	@Autowired
	LoginService loginService;
	
	@GetMapping("/")
	public String main(Model model) {
//		model.addAttribute("userName", "홍길동");
//		model.addAttribute("aaa123", "가나다");
//		model.addAttribute("product", 
//				    productService.getProductById(3L));
		return "main";
		// return "redirect:/list";
	}
	
	@GetMapping("/introduce")
	public String introduce() {
		return "introduce";
	}
	
	@GetMapping("/lookbook")
	public String lookbook() {
		return "lookBook";
	}
	
	@GetMapping("/logout")
	public String logoutForm(Model model) {
		loginService.logout();
		model.addAttribute("loginMember", null);
		return "main";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@PostMapping("/loginCheck")
	public String loginCheck(Member member, Model model) {
		Member login = loginService.login(member.getUserId(), member.getPw());
		if (login != null) {
	        model.addAttribute("loginMember", login); // 로그인된 사용자 정보를 모델에 추가
	        return "main";
	    } else {
	        // 로그인 실패 처리
	        return "redirect:/login"; // 실패 시 로그인 페이지로 리다이렉트
	    }
	}
	
	@GetMapping("/members")
	public String memberList(Model model) {
		model.addAttribute("memberList", memberMapper.selectAllMember());
		return "memberList";
	}
	
	@GetMapping("/members/new")
	public String add() {
		return "addMember";
	}
	
	@PostMapping("/newMember")
	public String addMember(Member member) {
		log.info("--------------------------------------------");
		log.info("member: {}", member.getName());
		log.info("member: {}", member.getUserId());
		log.info("member: {}", member.getPw());
		log.info("member: {}", member.getAddress());
		log.info("member: {}", member.getZipcode());
		memberMapper.insertMember(member);
		return "redirect:/members";
	}

	@GetMapping("/updateMemberForm")
	public String updateMemberForm(Model model, Long memberId) {
		System.out.println(memberMapper.selectByMemberId(memberId));
		model.addAttribute("member", memberMapper.selectByMemberId(memberId));

		return "memberUpdate";
	}
	
	@GetMapping("/items")
	public String list(Model model) {
		model.addAttribute("productList", productService.getAllProducts());
		return "productList";
	}
	
	@GetMapping("/items/new")
	public String save() {
		return "productRegister";
	}
	
	@GetMapping("/items/manage")
	public String manage(Model model) {
		model.addAttribute("productManage", productService.getAllProducts());
		return "productManage";
	}
	
	@GetMapping("/updateProductForm")
	public String updateProductForm(Model model, Long prodId) {
		System.out.println(productService.getProductById(prodId));
		model.addAttribute("prod", productService.getProductById(prodId));
		
		return "productUpdate";
	}

	@PostMapping("/updateMember")
	public String updateMember(Model model, HttpServletRequest request) {
		Long memberId = Long.parseLong(request.getParameter("memberId"));
		String name = request.getParameter("name");
		String userId = request.getParameter("userId");
		String pw = request.getParameter("pw");
		String address = request.getParameter("address");
		int zipcode = Integer.parseInt(request.getParameter("zipcode"));
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		int day = Integer.parseInt(request.getParameter("day"));

		Member member = Member.builder()
				.memberId(memberId)
				.name(name)
				.userId(userId)
				.pw(pw)
				.address(address)
				.zipcode(zipcode)
				.year(year)
				.month(month)
				.day(day)
				.build();

		memberMapper.updateMember(member);

		model.addAttribute("memberList", memberMapper.selectAllMember());
		return "memberList";
	}

	@GetMapping("/deleteMember")
	public String deleteMember (Model model, Long memberId) {
		memberMapper.deleteMember(memberId);
		System.out.println(memberMapper.deleteMember(memberId));
		model.addAttribute("memberList", memberMapper.selectAllMember());

		return "memberList";
	}
	
	@PostMapping("/updateProduct")
	public String updateProduct(Model model, HttpServletRequest request) {
		Long prodId = Long.parseLong(request.getParameter("prodId"));
		String prodName = request.getParameter("prodName");
		int prodPrice = Integer.parseInt(request.getParameter("prodPrice"));
		String prodDetail = request.getParameter("prodDetail");
		String prodImg = request.getParameter("prodImg");
		
		Product product = Product.builder()
	            .prodId(prodId)
	            .prodName(prodName)
	            .prodPrice(prodPrice)
	            .prodDetail(prodDetail)
	            .prodImg(prodImg)
	            .build();
		
		productService.updateProduct(product);
		
		model.addAttribute("productManage", productService.getAllProducts());
		return "productManage";
	}

	@GetMapping("productDetail")
	public String productDetail(Model model, Long prodId) {
		model.addAttribute("prod", productService.getProductById(prodId));
		return "productDetail";
	}

	@GetMapping("/deleteProduct")
	public String deleteProduct (Model model, Long prodId) {
		productService.deleteProduct(prodId);
		System.out.println(productService.deleteProduct(prodId));
		model.addAttribute("productManage", productService.getAllProducts());

		return "productManage";
	}
	
	@PostMapping("/new")
	public String saveNew(Product product, String prodImg) throws Exception {
		log.info("--------------------------------------------");
		log.info("product: {}", product.getProdName());
		log.info("product: {}", product.getProdPrice());
		log.info("product: {}", product.getProdDetail());
		log.info("product: {}", product.getProdImg());
		productService.addProduct(product);
		return "redirect:/items";
	}
	
	@GetMapping("/orders")
	public String orders(Model model) {
		model.addAttribute("orderList", orderService.getAllOrders());
		return "orderList";
	}
	
	@GetMapping("/order")
	public String order(Model model) {
		System.out.println(productService.getAllProducts());
		model.addAttribute("memberList", memberMapper.selectAllMember());
		model.addAttribute("productList", productService.getAllProducts());
		return "orderForm";
	}
	
	@PostMapping("/newOrder")
	public String addOrder(Orders orders) {
		System.out.println(orders);
		log.info("--------------------------------------------");
		log.info("orders: {}", orders.getMemberId());
		log.info("orders: {}", orders.getProdName());
		log.info("orders: {}", orders.getCount());
		orderService.newOrder(orders);
		return "redirect:/orders";
	}
	
}
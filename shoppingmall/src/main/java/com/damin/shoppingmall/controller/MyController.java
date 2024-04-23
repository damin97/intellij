package com.damin.shoppingmall.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.damin.shoppingmall.model.*;
import com.damin.shoppingmall.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.damin.shoppingmall.repository.MemberMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@WebServlet("/productDetail.jsp")
public class MyController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	MemberMapper memberMapper;
	
	@Autowired
	LoginService loginService;

	@Autowired
	HeartService heartService;

	@Autowired
	ShopService shopService;
	
	@GetMapping("/")
	public String main(Model model) {
		return "main";
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
	        return "loginForm"; // 실패 시 로그인 페이지로 리다이렉트
	    }
	}

	@GetMapping("/myPage")
	public String myPage() {
		return "myPage";
	}

	@GetMapping("/myAccount")
	public String myAccount(Model model, HttpSession session) {
		Member loginMember = (Member) session.getAttribute("loginMember");
		model.addAttribute("myList", memberMapper.selectByMemberId(loginMember.getMemberId()));
		return "myUpdate";
	}

	@PostMapping("/updateMyAccount")
	public String updateMyAccount(Model model, HttpServletRequest request) {
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

		model.addAttribute("myList", memberMapper.selectByMemberId(memberId));
		return "myUpdate";
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

	@GetMapping("/myLikes")
	public String myLikes(Model model, HttpSession session) {
		Member loginMember = (Member) session.getAttribute("loginMember");
		Long memberId = loginMember.getMemberId();

		List<Map<String, Object>> heartProductList = new ArrayList<>();
		List<Heart> heartList = heartService.getAllHeartByMemberId(memberId);

		for (Heart heart : heartList) {
			Map<String, Object> heartProduct = new HashMap<>();
			heartProduct.put("likeId", heart.getLikeId());
			heartProduct.put("likeClick", heart.isLikeClick());
			heartProduct.put("memberId", heart.getMemberId());
			heartProduct.put("prodId", heart.getProdId());

			// 제품 정보 조회 및 추가
			Product product = productService.getProductById(heart.getProdId());
			heartProduct.put("prodName", product.getProdName());
			heartProduct.put("prodPrice", product.getProdPrice());
			heartProduct.put("prodImg", product.getProdImg());

			heartProductList.add(heartProduct);
		}

		model.addAttribute("heartProductList", heartProductList);
		return "myLikes";
	}

	@GetMapping("/myShops")
	public String myShops(Model model, HttpSession session) {
		Member loginMember = (Member) session.getAttribute("loginMember");
		Long memberId = loginMember.getMemberId();

		List<Map<String, Object>> shopProductList = new ArrayList<>();
		List<Shop> shopList = shopService.getAllShopByMemberId(memberId);

		for (Shop shop : shopList) {
			Map<String, Object> shopProduct = new HashMap<>();
			shopProduct.put("shopId", shop.getShopId());
			shopProduct.put("count", shop.getCount());
			shopProduct.put("memberId", shop.getMemberId());
			shopProduct.put("prodId", shop.getProdId());

			// 제품 정보 조회 및 추가
			Product product = productService.getProductById(shop.getProdId());
			shopProduct.put("prodName", product.getProdName());
			shopProduct.put("prodPrice", product.getProdPrice());
			shopProduct.put("prodDetail", product.getProdDetail());
			shopProduct.put("prodImg", product.getProdImg());

			shopProductList.add(shopProduct);
		}

		model.addAttribute("shopProductList", shopProductList);
		return "myShops";
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

	@GetMapping("/productDetail")
	public String productDetail(Model model, Long prodId, HttpSession session) {

		Member loginMember = (Member) session.getAttribute("loginMember");
		if (loginMember != null) {
			model.addAttribute("login", true);
		} else {
			model.addAttribute("login", false);
		}

		model.addAttribute("prod", productService.getProductById(prodId));
		model.addAttribute("like", heartService.getHeartByProdId(prodId));
		return "productDetail";
	}

	@GetMapping("/heartClick")
	public @ResponseBody Heart heartClick(@RequestParam boolean likeClick, @RequestParam Long prodId, HttpSession session) throws IOException {
		// 로그인 상태 확인
		Member loginMember = (Member) session.getAttribute("loginMember");
		if (loginMember == null) {
			return null;
		} else {
			Heart heart = new Heart(likeClick, loginMember.getMemberId(), prodId);
			// Heart 테이블에서 해당 prodId 값으로 기존 데이터 조회
			Heart existingHeart = heartService.getHeartByProdId(prodId);

			if (existingHeart == null) {
				// 데이터베이스에 해당 prodId 값의 데이터가 없으면 새로운 데이터 추가
				heartService.addLike(heart);
			} else {
				// 데이터베이스에 해당 prodId 값의 데이터가 이미 존재하면 삭제
				heartService.deleteLike(prodId);
			}
			return heart;
		}
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

	@GetMapping("/toMyShop")
	public @ResponseBody String myShop(@RequestParam Long prodId, @RequestParam Integer count, HttpSession session, Model model) {
		Member loginMember = (Member) session.getAttribute("loginMember");

		if(loginMember == null) {
			model.addAttribute("login", false);
			model.addAttribute("error", "로그인 후 이용 가능합니다.");
		} else {
			model.addAttribute("login", true);
			Long memberId = loginMember.getMemberId();

			Shop shop = new Shop(memberId, prodId, count);
			shopService.addShop(shop);
		}
		return "";
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
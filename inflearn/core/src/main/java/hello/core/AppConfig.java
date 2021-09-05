package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()
    // new MemoryMemberRepository로 2개의 인스턴스 생성돼서 싱글톤이 깨지는거 아닌가? -> test code
    // AppConfig@CGFLIBXXXXXXX
    // CGLIB를 사용하여 바이트 코드를 조작해서 임의의 다른 클래스를 생성하여 싱클톤이 보장되도록 해준다.

    //CGLIB 예상 코드드
//   if(memoryMemberRepository가 스프링 컨테이너에 등록되어 있으면){
//        return 스프링 컨테이너에서 찾아서 반환
//    }else{
//        기존 로직을 호출해서 MemoryMemberRepository를 생성하고 스프링 컨테이너에 등록
//        return 반환
//    }

    @Bean
    public MemberService memberService() {
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());

    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }


    @Bean
    public DiscountPolicy discountPolicy() {
        System.out.println("AppConfig.discountPolicy");
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }


}

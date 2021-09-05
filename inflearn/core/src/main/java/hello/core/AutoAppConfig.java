package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.core.member",
//        basePackageClasses = AutoAppConfig.class,
        // 지정 안하면? @ComponentScan이 붙은 설정 정보 클래스의 패키지인 hello.core부터 시작해서 다 뒤진다.

        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)

)
public class AutoAppConfig {
    // 수동 빈과 자동 빈 이름이 충돌되면 수동 빈 등록이 우선권(오버라이딩)을 가진다.
    // 대부분 의도적으로 설정하기보다는 여러 설정이 꼬인경우가 많다 -> 잡기 어려운 애매한 버그가 터질 수 있다.
    // 수동빈과 자동빈 충돌시 오류나도록 설정 -> 충돌 나지 않도록 사용해야한다.

    /*
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    */
}

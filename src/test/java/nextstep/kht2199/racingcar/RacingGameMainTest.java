package nextstep.kht2199.racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author heetaek.kim
 */
class RacingGameMainTest {

	@ParameterizedTest
	@DisplayName("쉽표로 입력받고, 각 이름이 5자 이하를 검증")
	@MethodSource(value = "acceptCarNamesSources")
	void acceptCarNames(String carNamesString, boolean validation) {
		assertThat(RacingGameMain.validateCarNames(carNamesString))
			.isEqualTo(validation);
	}

	static Stream<Arguments> acceptCarNamesSources() {
		return Stream.of(
			Arguments.of("aaa", false),
			Arguments.of("aaa, bbb", true),
			Arguments.of("aaa, bbb, ccc", true),
			Arguments.of("aaa, bbb, cccc", true),
			Arguments.of("aaa, bbb, ccccc", true),
			Arguments.of("aaa, bbb, cccccc", false)
		);
	}
}
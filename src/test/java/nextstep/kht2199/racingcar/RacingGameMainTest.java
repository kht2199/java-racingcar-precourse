package nextstep.kht2199.racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
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

	@ParameterizedTest
	@DisplayName("자동차 이름 목록으로 자동차 인스턴스 생성")
	@MethodSource(value = "manipulationCarsByNamesSources")
	void manipulationCarsByNames(String[] carNames, int length) {
		List<RacingCar> cars = RacingGameMain.manipulationCarsByNames(carNames);
		assertThat(cars.size()).isEqualTo(length);
		for (int i = 0, carsSize = cars.size(); i < carsSize; i++) {
			RacingCar car = cars.get(i);
			assertThat(car.carName()).isEqualTo(carNames[i].trim());
		}
	}

	static Stream<Arguments> manipulationCarsByNamesSources() {
		return Stream.of(
			Arguments.of(new String[]{"aaa"}, 1),
			Arguments.of(new String[]{"aaa", "bbb"}, 2)
		);
	}
}
package nextstep.kht2199.racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author heetaek.kim
 */
class RacingGameTest {

	@ParameterizedTest
	@MethodSource("initializationSource")
	@DisplayName("게임 생성시 이동 횟수를 2회이상, 자동차 2대이상, 초기상태는 STARTED 검증")
	void initialization(List<RacingCar> racingCars, int moved, String message) {
		if (message != null) {
			assertThatThrownBy(() -> new RacingGame(racingCars, moved))
				.isInstanceOf(AssertionError.class)
				.hasMessageContaining(message)
			;
			return;
		}
		RacingGame racingGame = new RacingGame(racingCars, moved);
		assertThat(racingGame.started()).isEqualTo(true);
	}

	static Stream<Arguments> initializationSource() {
		RacingCar sample = new RacingCar("temp");
		return Stream.of(
			Arguments.of(Lists.newArrayList(sample), 10, "count of cars must more than 1"),
			Arguments.of(Lists.newArrayList(sample, sample), 1, "move value must greater than 1"),
			Arguments.of(Lists.newArrayList(sample, sample), 10, null)
		);
	}

}
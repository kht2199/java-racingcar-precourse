package nextstep.kht2199.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author heetaek.kim
 */
class RacingTrackTest {

	@RepeatedTest(value = 50)
	@MethodSource("randForMoveSource")
	@DisplayName("특정 숫자 구간에 대한 정수를 리턴하도록 랜덤함수를 구현")
	void rand() {
		int rand = RacingTrack.rand(10, 20);
		assertThat(rand)
			.isGreaterThanOrEqualTo(10)
			.isLessThanOrEqualTo(20)
		;
	}

}
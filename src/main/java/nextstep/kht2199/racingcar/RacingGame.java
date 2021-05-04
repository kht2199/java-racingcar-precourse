package nextstep.kht2199.racingcar;

import java.util.List;

/**
 *
 * 게임룰과 기본 입력값을 설정한다.
 *
 * 기본 입력값
 * 1. 자동차 목록
 * 2. 총 이동 횟수
 *
 * @author heetaek.kim
 */
public class RacingGame {

	private final RacingTrack track;

	private final int moves;

	private final RacingGameConsolePrinter printer;

	private GameState state;

	public RacingGame(List<RacingCar> cars, int moves) {
		assert cars.size() > 1 : "count of cars must more than 1";
		assert moves > 1 : "move value must greater than 1";
		this.track = new RacingTrack(cars);
		this.moves = moves;
		this.printer = new RacingGameConsolePrinter(this, track);
		this.state = GameState.STARTED;
	}

	public void start() {
		int moved = 0;
		while (moved < moves) {
			track.move();
			moved++;
			printer.print();
		}
		this.state = GameState.ENDED;
		printer.print();
	}

	public boolean ended() {
		return this.state == GameState.ENDED;
	}

	public boolean started() {
		return this.state == GameState.STARTED;
	}

	public RacingGameConsolePrinter printer() {
		return printer;
	}
}

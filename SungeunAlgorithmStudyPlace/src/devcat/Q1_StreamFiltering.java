package devcat;

import java.util.Arrays;
import java.util.stream.LongStream;

public class OneLongStream {
	public int[] solution(int[] lottos, int[]winNums) {
		return LongStream.of(
				(lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l) || l == 0).count(),
				(lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l)).count()
		).mapToInt(op -> (int)(op > 6 ? op-1 : op)).toArray();
	}
}
//1. LongStream 클래스에서 of(value, vlaue2, ...)메서드 실행 / 인자가 복수일 경우 stream 반환
//2. value = 7 - 
package devcat;

import java.util.Arrays;
import java.util.stream.LongStream;

public class Q1_StreamFiltering {
	public int[] solution(int[] lottos, int[]winNums) {
		return LongStream.of(
				(lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l) || l == 0).count(),
				(lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l)).count()
		).mapToInt(op -> (int)(op > 6 ? op-1 : op)).toArray();
	}
}
//1. LongStream 클래스에서 of(value, vlaue2, ...)메서드 실행 / 인자가 복수일 경우 stream 반환
//2. value = 7 - (맞은 복권의 갯수 + 0의 갯수)
//3. value2 = 7 - (맞은 복권의 갯수)
//4. mapToInt메서드로 7이상의 값에 빼기 1을 처리한 stream 반환
//5. 을 int배열로 반환

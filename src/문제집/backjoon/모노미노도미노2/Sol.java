package 문제집.backjoon.모노미노도미노2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
비트연산자 이용 - 백준 답
 */

public class Sol {
    static int score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 블록 수
        int N = Integer.parseInt(br.readLine(), 10);
        // 초록색 보드
        byte boardG[] = new byte[6];
        // 파란색 보드
        byte boardB[] = new byte[6];

        // 블록 수 만큼 반복
        for (int i = 0; i < N; i++) {
            int type;
            int x;
            int y;
            int idx1, idx2;
            String nums;

            try {
                nums = br.readLine();
            } catch (IOException e) {
                break;
            }

            // 타입, x, y 값 읽기
            idx1 = nums.indexOf(' ');
            idx2 = nums.indexOf(' ', idx1 + 1);
            type = Integer.parseInt(nums.substring(0, idx1), 10);
            x = Integer.parseInt(nums.substring(idx1 + 1, idx2), 10);
            y = Integer.parseInt(nums.substring(idx2 + 1, nums.length()), 10);

            // 타입에 따라 처리
            //
            // 빨간색 영역의 높이는 관계 없으므로 좌우 위치 값만 사용
            // 초록색 보드 기준 y, 파란색 보드 기준 x
            //
            // 파란색 보드와 초록색 보드를 별도로 처리하며
            // 파란색 보드는 90도 회전하면 초록색 보드와 같으므로
            // 입력하는 블록을 90도 회전한 결과를 기준으로 초록색 보드처럼 처리
            if (type == 1) {
                processDotBlk(boardG, y);
                processDotBlk(boardB, x);
            } else if (type == 2) {
                processHorizontalBlk(boardG, y);
                processVerticalBlk(boardB, x);
            } else if (type == 3) {
                processVerticalBlk(boardG, y);
                processHorizontalBlk(boardB, x);
            }
        }

        // 결과 출력
        System.out.println(score);
        System.out.println(getRemainTile(boardG) + getRemainTile(boardB));
    }

    private static void processDotBlk(byte[] board, int y) {
        // 보드에 적절한 위치로 블럭 삽입
        int i;
        for (i = 3; i >= 0; i--) {
            if (((board[i] >>> y) & 0x1) != 0) {
                board[i + 1] |= (1 << y);
                break;
            }
        }

        if (i == -1 && ((board[0] >>> y) & 0x1) == 0) {
            board[0] |= (1 << y);
        }

        // 행이 가득찬 경우 검사 및 블럭 내리기 수행
        processBoard(board);
    }

    private static void processHorizontalBlk(byte[] board, int y) {
        // 보드에 적절한 위치로 블럭 삽입
        int i;
        for (i = 3; i >= 0; i--) {
            if (((board[i] >>> y) & 0b11) != 0) {
                board[i + 1] |= (0b11 << y);
                break;
            }
        }

        if (i == -1 && ((board[0] >>> y) & 0x1) == 0 &&
                ((board[0] >>> (y + 1)) & 0x1) == 0) {
            board[0] |= (0b11 << y);
        }

        // 행이 가득찬 경우 검사 및 블럭 내리기 수행
        processBoard(board);
    }

    private static void processVerticalBlk(byte[] board, int y) {
        // 보드에 적절한 위치로 블럭 삽입
        int i;
        for (i = 3; i >= 0; i--) {
            if (((board[i] >>> y) & 0x1) != 0) {
                board[i + 1] |= (1 << y);
                board[i + 2] |= (1 << y);
                break;
            }
        }

        if (i == -1 && ((board[0] >>> y) & 0x1) == 0 &&
                ((board[1] >>> y) & 0x1) == 0) {
            board[0] |= (1 << y);
            board[1] |= (1 << y);
        }

        // 행이 가득찬 경우 검사 및 블럭 내리기 수행
        processBoard(board);
    }

    // 보드 내 남아있는 타일의 개수 반환
    private static int getRemainTile(byte[] board) {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            if (board[i] != 0) {
                int tiles = board[i];
                for (int k = 0; k < 4; k++) {
                    if ((tiles & 0x1) != 0) {
                        count++;
                    }
                    tiles >>>= 1;
                }
            }
        }

        return count;
    }

    // 행이 가득찬 경우 검사 및 블럭 내리기 수행
    private static void processBoard(byte[] board) {
        // 행이 가득 찬 경우 처리
        for (int i = 0; i < 6; i++) {
            if ((board[i] & 0xf) == 0xf) {
                board[i] = 0;
                if (i < 5 && (board[i + 1] & 0xf) == 0xf) {
                    board[i + 1] = 0;
                    // 가득찬 라인 제거
                    deleteLine(board, i + 2, 2);
                    score += 2;
                } else {
                    // 가득찬 라인 제거
                    deleteLine(board, i + 1, 1);
                    score++;
                }
            }
        }

        // 연한 색 칸에 블록이 있는 경우 처리
        if (board[5] != 0) {
            for (int j = 0; j < 4; j++) {
                board[j] = board[j + 2];
            }
            board[4] = 0;
            board[5] = 0;
        } else if (board[4] != 0) {
            for (int j = 0; j < 5; j++) {
                board[j] = board[j + 1];
            }
            board[4] = 0;
        }
    }

    // 가득찬 라인 행 위의 블럭을 라인 통째로 내릴 수 있는 곳 까지 내리기
    private static void deleteLine(byte[] board, int from, int height) {
        for (int i = from; i < 6; i++) {
            if (board[i] != 0) {
                for (int j = 1; j <= height; j++) {
                    board[i - j] = board[i - j + height];
                    board[i - j + height] = 0;
                }
            }
        }

        // 블럭을 내린 뒤 또 체워져 있을 수도 있는 행을 검사
        processBoard(board);
    }
}
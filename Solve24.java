public class Solve24 {

    public static void main(String[] args) {
        int[] cards = new int[4];
        if (args.length != 4) {
            System.err.println("Need four cards");
            return;
        }

        System.out.print("Four cards are:");
        for (int i = 0; i < 4; i++) {
            cards[i] = Integer.parseInt(args[i]);
            System.out.print(" " + cards[i]);
        }
        System.out.println();

        solve24(cards);
    }

    private static void solve24(int[] cards) {
        double[] card_result = new double[7];
        int i, j, p, q, r;
        boolean solution = false;
        for (i = 0; i < cards.length; i++) {
            card_result[i] = cards[i];
        }
        String[] results = new String[3];
        for (i = 0; i < results.length; i++) {
            results[i] = "";
        }

        for (i = 0; i < cards.length; i++) {
            for (j = 0; j < cards.length; j++) {
                // First calculation
                if (i != j) {
                    for (int op1 = 0; op1 < 4; op1++) {
                        results[0] = "";
                        switch (op1) {
                            case 0:
                                card_result[4] = card_result[i] + card_result[j];
                                results[0] += "(" + card_result[i] + "+" + card_result[j] + ")";
                                break;
                            case 1:
                                card_result[4] = card_result[i] - card_result[j];
                                results[0] += "(" + card_result[i] + "-" + card_result[j] + ")";
                                break;
                            case 2:
                                card_result[4] = card_result[i] * card_result[j];
                                results[0] += "(" + card_result[i] + "*" + card_result[j] + ")";
                                break;
                            case 3:
                                card_result[4] = card_result[i] / card_result[j];
                                results[0] += "(" + card_result[i] + "/" + card_result[j] + ")";
                                break;
                        }

                        for (p = 0; p < 5; p++) {
                            for (q = 0; q < 5; q++) {
                                // Step 2
                                if (p != i && p != j && q != i && q != j && p != q) {
                                    for (int op2 = 0; op2 < 4; op2++) {
                                        results[1] = results[0];

                                        switch (op2) {
                                            case 0:
                                                card_result[5] = card_result[p] + card_result[q];
                                                if (p == 4) {
                                                    results[1] += "+" + card_result[q];
                                                } else if (q == 4) {
                                                    results[1] = card_result[p] + "+" + results[0];
                                                } else {
                                                    results[1] = results[0] + " " + "("
                                                            + card_result[p] + "+" + card_result[q]
                                                            + ")";
                                                }
                                                break;
                                            case 1:
                                                card_result[5] = card_result[p] - card_result[q];
                                                if (p == 4) {
                                                    results[1] += "-" + card_result[q];
                                                } else if (q == 4) {
                                                    results[1] = card_result[p] + "-" + results[0];
                                                } else {
                                                    results[1] = results[0] + " " + "("
                                                            + card_result[p] + "-" + card_result[q]
                                                            + ")";
                                                }
                                                break;
                                            case 2:
                                                card_result[5] = card_result[p] * card_result[q];
                                                if (p == 4) {
                                                    results[1] += "*" + card_result[q];
                                                } else if (q == 4) {
                                                    results[1] = card_result[p] + "*" + results[0];
                                                } else {
                                                    results[1] = results[0] + " " + "("
                                                            + card_result[p] + "*" + card_result[q]
                                                            + ")";
                                                }
                                                break;
                                            case 3:
                                                card_result[5] = card_result[p] / card_result[q];
                                                if (p == 4) {
                                                    results[1] += "/" + card_result[q];
                                                } else if (q == 4) {
                                                    results[1] = card_result[p] + "/" + results[0];
                                                } else {
                                                    results[1] = results[0] + " " + "("
                                                            + card_result[p] + "/" + card_result[q]
                                                            + ")";
                                                }
                                                break;
                                        }

                                        for (r = 0; r < 5; r++) {
                                            // Final step
                                            if (r != i && r != j && r != p && r != q) {
                                                for (int op = 0; op < 6; op++) {
                                                    results[2] = results[1];
                                                    switch (op) {
                                                        case 0:
                                                            card_result[6] = card_result[r]
                                                                    + card_result[5];
                                                            if (r != 4) {
                                                                results[2] = card_result[r] + "+"
                                                                        + results[1];
                                                            } else {
                                                                results[2] = results[1].replace(
                                                                        " ", "+");
                                                            }
                                                            break;
                                                        case 1:
                                                            card_result[6] = card_result[r]
                                                                    - card_result[5];
                                                            if (r != 4) {
                                                                results[2] = card_result[r] + "-"
                                                                        + "(" + results[1] + ")";
                                                            } else {
                                                                results[2] = results[1].replace(
                                                                        " ", "-");
                                                            }
                                                            break;
                                                        case 2:
                                                            card_result[6] = card_result[r]
                                                                    * card_result[5];
                                                            if (r != 4) {
                                                                results[2] = card_result[r] + "*"
                                                                        + "(" + results[1] + ")";
                                                            } else {
                                                                results[2] = results[1].replace(
                                                                        " ", "*");
                                                            }
                                                            break;
                                                        case 3:
                                                            card_result[6] = card_result[r]
                                                                    / card_result[5];
                                                            if (r != 4) {
                                                                results[2] = card_result[r] + "/"
                                                                        + "(" + results[1] + ")";
                                                            } else {
                                                                results[2] = results[1].replace(
                                                                        " ", "/");
                                                            }
                                                            break;
                                                        case 4:
                                                            card_result[6] = card_result[5]
                                                                    - card_result[r];
                                                            if (r != 4) {
                                                                results[2] = results[1] + "-"
                                                                        + card_result[r];
                                                            } else {
                                                                results[2] = "-"
                                                                        + results[1].replace(" ",
                                                                                "+");
                                                            }
                                                            break;
                                                        case 5:
                                                            card_result[6] = card_result[5]
                                                                    / card_result[r];
                                                            if (r != 4) {
                                                                results[2] = results[1] + "/"
                                                                        + card_result[r];
                                                            } else {
                                                                results[2] = "1/"
                                                                        + results[1].replace(" ",
                                                                                "*");
                                                            }
                                                            break;
                                                    }
                                                    if (card_result[6] == 24) {
                                                        System.out.println(results[2]);
                                                        solution = true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (!solution) {
            System.out.println("no solution");
        }
    }
}

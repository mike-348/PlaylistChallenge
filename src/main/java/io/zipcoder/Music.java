package io.zipcoder;

public class Music {

    private String[] playList;

    public Music(String[] playList) {
        this.playList = playList;
    }

    public Integer selection(Integer startIndex, String selection) {
//        return null;

        // the plan:
        // loop through entire array until you find the selection at index
        // calculate distance from index to
        // calculate distance from index to end
        // return whichever is smaller

//        int skipsBack;
//        int skipsFwd;
//
//        for (int i = 0; i < playList.length; i++) {
//            if (playList[i].equals(selection)) {
//                int selectionIndex = i;
//                if (selectionIndex < startIndex) {
//                    skipsBack = startIndex - selectionIndex;
//                } else if (selectionIndex > startIndex) {
//                    skipsFwd = Math.abs(startIndex - selectionIndex);
//                }
//            }
//        }
//        if (skipsFwd < skipsBack) {
//            return skipsFwd;
//        } else return skipsBack;


        int fwdCount = 0;
        int bwdCount = 0;
        int lowestCount = 0;

        //count fwd
        for (int i = startIndex; i < playList.length; i++) {
            if (!playList[i].equals(selection)) {
                fwdCount++;
            } else if (playList[i].equals(selection)) {
                break;
            }
        }
        //count backward
        for (int i = startIndex; i >= 0; i--) {
            if (!playList[i].equals(selection)) {
                bwdCount++;
            } else if (playList[i].equals(selection)) {
                //accounts for case where starting index = 0 and selection and selection is the last element
                bwdCount++;
                break;
            }
        }
        for (int i = playList.length - 1; i > startIndex; i--) {
            if (!playList[i].equals(selection)) {
                bwdCount++;
            } else if (playList[i].equals(selection)) {
                break;
            }
        }

        if (fwdCount < bwdCount) {
            lowestCount = fwdCount;
        } else if (bwdCount <= fwdCount) {
            lowestCount = bwdCount;
        }

        return lowestCount;

    }
}

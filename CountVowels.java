class CountVowels {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int len = words.length;
        int[] temp = new int[len];
        int[] out = new int[queries.length];
        int count = 0;

        for(int i=0; i<len; i++){
            String s = words[i];
            char a = s.charAt(0);
            char b = s.charAt(s.length()-1);
            if((a=='a' || a=='e' || a=='i' || a=='o' || a=='u') && (b=='a' || b=='e' || b=='i' || b=='o' || b=='u')){
                count++;
            }
            temp[i] = count;
        }

        for(int i=0; i<queries.length; i++){
            if(queries[i][0] == 0){
                out[i] = temp[queries[i][1]];
            }else if(queries[i][0] == queries[i][1]){
                if(i != 0){
                    out[i] = temp[queries[i][0]]-temp[queries[i][0]-1];
                }else{
                    int a = queries[i][1];
                    if (a != 0){
                        out[i] = temp[a]-temp[a-1];
                    }else {
                        out[i] = temp[a];
                    }

                }
            }else{
                if (temp[queries[i][1]] == temp[queries[i][0]]){
                    if (temp[queries[i][0]] != 0){
                        int a = queries[i][0];
                        if (temp[a-1] == temp[a]) {
                            out[i] = 0;
                        }else{
                            out[i] = temp[a]-temp[a-1];
                        }
                    }else {
                        out[i] = temp[queries[i][1]] - temp[queries[i][0]];;
                    }
                }else {
                    int a = queries[i][0];
                    if (a!=0){
                        out[i] = temp[queries[i][1]]-temp[a-1];
                    }else {
                        out[i] = temp[queries[i][1]] - temp[queries[i][0]];
                    }
                }
            }
        }
        return out;
    }
}

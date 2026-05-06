class Solution {
    List<String> res = new ArrayList<>();
    HashMap<Character,String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {

        if(digits== ""){
            return res;
        }

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");


        dfs(digits, 0, "");

        return res;
    }
    private void dfs(String digits, int i, String sub){
        if(i==digits.length()){
            res.add(sub);
            return;
        }

        String t = map.get(digits.charAt(i));

        for(int j = 0;j<t.length();j++){
            dfs(digits, i + 1 , sub + t.charAt(j));
        }

    }
}

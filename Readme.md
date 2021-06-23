 아래가 옛날 방식!
 
    @GetMapping(path="/hello")
    public String getHello(){
        return "get Hello";
    }
-----------------
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String defaultPage(){
        return "HelloWorld";
    }

--------
    @GetMapping("query-param03")
    public String queryParam3(UserRequest userRequest){
        return userRequest.toString();
    }

- 현업에서 가장 많이 사용해!

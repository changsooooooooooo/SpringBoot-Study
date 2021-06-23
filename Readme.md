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
------
      @JsonProperty("phone_number")
      private String phoneNumber;

- 들어오는 것의 경우와 스타일이 다른 경우, 혹은 자바 컨벤션과 다른 경우 지정하는 것

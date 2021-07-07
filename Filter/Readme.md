- Filter : 사용자가 보내는 정보가 정말 어떠한게 들어있는가!


    br.lines().forEach(
                line -> log.info("url : {}, line : {}", url, line)
    );

    @PostMapping("")
    public User user(@RequestBody User user){
        log.info("User : {}", user);
        return user;
    }

- 필터에서 이미 읽은 후라 Post 할 때 남은 읽을 객체가 없는것!
  

    ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);
    
    ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse) response);


- 그래서 caching 으로 잡는 것!


    Resolved [org.springframework.http.converter.HttpMessageNotReadableException: Required request body is missing: public com.example.filter.dto.User com.example.filter.controller.ApiController.user(com.example.filter.dto.User)]

- 왜 이런 메시지가 뜰까??


    public ContentCachingRequestWrapper(HttpServletRequest request) {
      super(request);
      int contentLength = request.getContentLength();
      this.cachedContent = new ByteArrayOutputStream(contentLength >= 0 ? contentLength : 1024);
      this.contentCacheLimit = null;
    }

- 애초에 바이트 길이만을 잡기 때문에 그런거!
    -> 내용을 버린다고 보면 된다
    -> 길이만 남기는 것!
    -> 길이만 저장하고 나머지는 필터를 통해 실제로 스프링 통해 불릴 때 해결이 되는 것!
  

    String resContent = new String(httpServletResponse.getContentAsByteArray());
    httpServletResponse.copyBodyToResponse();

- 얘는 보내줘야 되는데 이미 다 읽은거라 없어진 거지!

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNOtValidException(MethodArgumentNotValidException e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

- 해당 excpeitonhadler가 특정 class 내에서 작동하게 하려면 해당 class에 메쏘드 기재하면 된다

    @AssertTrue(message="yyyyMM의 형식에 맞지 않습니다")
    public boolean isReqYearMonthvalidation(){
        this.reqYearMonth = getReqYearMonth()+"01";
        try{
            LocalDate localDate = LocalDate.parse(this.reqYearMonth, DateTimeFormatter.ofPattern("yyyyMMdd"));
        }catch(Exception e){
            return false;
        }
        return true;
    }

- assertTrue는 is가 앞에 prefix로 들어가야!
- 여기서는 결국 하나의 클래스에서만 사용한다.....Validator만들자!

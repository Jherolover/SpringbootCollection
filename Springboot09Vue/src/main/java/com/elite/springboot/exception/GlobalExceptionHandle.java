package com.elite.springboot.exception;

import com.elite.springboot.common.ErrorEnum;
import com.elite.springboot.common.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 我们定义一个全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandle {
    //通用的异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R commonHandle(Exception e){
        e.printStackTrace();
        return R.fail(ErrorEnum.FAIL.getCode(),ErrorEnum.FAIL.getMessage());
    }
    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public R commonHandle(NullPointerException e){
        e.printStackTrace();
        return R.fail(ErrorEnum.NPERROR.getCode(),ErrorEnum.NPERROR.getMessage());
    }
    //空指针异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R commonHandle(ArithmeticException e){
        e.printStackTrace();
        return R.fail(ErrorEnum.DIVERROR.getCode(),ErrorEnum.DIVERROR.getMessage());
    }
    //自定义异常
    //空指针异常
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public R commonHandle(MyException e){
        e.printStackTrace();
        return R.fail(ErrorEnum.MYEXCEPTION.getCode(),ErrorEnum.MYEXCEPTION.getMessage());
    }


}

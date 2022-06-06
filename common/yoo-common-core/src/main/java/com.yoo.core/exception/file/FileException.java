package com.yoo.core.exception.file;

import com.yoo.core.exception.base.BaseException;

/**
 * 文件信息异常类
 * 
 * @author anYoooo
 */
public class FileException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }

}

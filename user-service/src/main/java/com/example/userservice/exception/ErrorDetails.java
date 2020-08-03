package com.example.userservice.exception;

import lombok.Data;

@Data
public class ErrorDetails
{
   private String errorCode;
   private String errorMessage;
}

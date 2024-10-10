package com.jgmedellin.Cryptrade.domain;

import lombok.Data;

@Data
public class TwoFactorAuth {

  private boolean isEnabled = false;

  private VerificationType sendTo;

}
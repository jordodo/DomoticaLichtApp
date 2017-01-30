package com.example.jordi.domoticalichtapp;

import net.schmizz.sshj.transport.verification.HostKeyVerifier;

import java.security.PublicKey;

public class NullHostKeyVerifier implements HostKeyVerifier
{

    @Override
    public boolean verify(String arg0, int arg1, PublicKey arg2)
    {
        return true;
    }

}
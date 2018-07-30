package com.breadwallet.protocols.messageexchange.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.protobuf.ByteString;

/**
 * BreadWallet
 * <p/>
 * Created by Shivangi Gandhi on <shivangi@brd.com> 7/25/18.
 * Copyright (c) 2018 breadwallet LLC
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
public abstract class RequestMetaData extends MetaData {
    private String mMessageType;
    private ByteString mSenderPublicKey;
    private String mCurrencyCode;
    private String mNetwork;
    private String mAddress;
    private String mAmount;
    private String mMemo;

    public RequestMetaData(String id, String messageType, ByteString senderPublicKey, String currencyCode,
                           String network, String address, String amount, String memo) {
        super(id);
        mMessageType = messageType;
        mSenderPublicKey = senderPublicKey;
        mCurrencyCode = currencyCode;
        mNetwork = network;
        mAddress = address;
        mAmount = amount;
        mMemo = memo;
    }

    public RequestMetaData(Parcel source) {
        super(source);
        mMessageType = source.readString();
        mSenderPublicKey = (ByteString) source.readSerializable();
        mCurrencyCode = source.readString();
        mNetwork = source.readString();
        mAddress = source.readString();
        mAmount = source.readString();
        mMemo = source.readString();
    }

    public String getMessageType() {
        return mMessageType;
    }

    public void setMessageType(String messageType) {
        mMessageType = messageType;
    }

    public ByteString getSenderPublicKey() {
        return mSenderPublicKey;
    }

    public void setSenderPublicKey(ByteString senderPublicKey) {
        mSenderPublicKey = senderPublicKey;
    }

    public String getCurrencyCode() {
        return mCurrencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        mCurrencyCode = currencyCode;
    }

    public String getNetwork() {
        return mNetwork;
    }

    public void setNetwork(String network) {
        mNetwork = network;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getAmount() {
        return mAmount;
    }

    public void setAmount(String amount) {
        mAmount = amount;
    }

    public String getMemo() {
        return mMemo;
    }

    public void setMemo(String memo) {
        mMemo = memo;
    }

    @Override
    protected void writeToParcel(Parcel destination) {
        destination.writeString(mMessageType);
        destination.writeSerializable(mSenderPublicKey);
        destination.writeString(mCurrencyCode);
        destination.writeString(mNetwork);
        destination.writeString(mAddress);
        destination.writeString(mAmount);
        destination.writeString(mMemo);
    }
}

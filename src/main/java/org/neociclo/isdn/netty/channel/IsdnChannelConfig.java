/**
 * Neociclo Accord, Open Source B2Bi Middleware
 * Copyright (C) 2005-2009 Neociclo, http://www.neociclo.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * $Id$
 */
package org.neociclo.isdn.netty.channel;

import net.sourceforge.jcapi.message.parameter.AdditionalInfo;
import net.sourceforge.jcapi.message.parameter.BearerCapability;
import net.sourceforge.jcapi.message.parameter.HighLayerCompatibility;
import net.sourceforge.jcapi.message.parameter.LowLayerCompatibility;
import net.sourceforge.jcapi.message.parameter.NCCI;
import net.sourceforge.jcapi.message.parameter.PLCI;
import net.sourceforge.jcapi.message.parameter.sub.B1Configuration;
import net.sourceforge.jcapi.message.parameter.sub.B2Configuration;
import net.sourceforge.jcapi.message.parameter.sub.B3Configuration;

import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.DefaultChannelConfig;
import org.neociclo.capi20.parameter.B1Protocol;
import org.neociclo.capi20.parameter.B2Protocol;
import org.neociclo.capi20.parameter.B3Protocol;
import org.neociclo.capi20.parameter.BChannelOperation;
import org.neociclo.capi20.parameter.CompatibilityInformationProfile;
import org.neociclo.x25.facilities.FacilitiesSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rafael Marins
 * @version $Rev$ $Date$
 */
public final class IsdnChannelConfig extends DefaultChannelConfig {

    private static final Logger logger = LoggerFactory.getLogger(IsdnChannelConfig.class);

    private ChannelPipelineFactory pipelineFactory;

    // REGISTER_REQ config
    private int maxBDataLen;
    private int maxBDataBlocks;
    private int maxLogicalConnection;

    // CONNECT_REQ config
    private CompatibilityInformationProfile compatibilityInformationProfile;
    private B1Protocol b1;
    private B2Protocol b2;
    private B3Protocol b3;

    // CONNECT_REQ config: jcapi types used on channel config
    private B3Configuration b3Configuration;
    private B2Configuration b2configuration;
    private B1Configuration b1configuration;
    private BChannelOperation bChannelOperation;
    private AdditionalInfo additionalInfo;
    private BearerCapability bearerCapability;
    private LowLayerCompatibility lowLayerCompatibility;
    private HighLayerCompatibility highLayerCompatibility;
    private PLCI plci;

    // X.25 - Logical Channel config
    private NCCI ncci;
    private short logicalChannelIdentifier;
    private boolean deliveryConfirmationEnabled;
    private FacilitiesSupport facilities;

    /**
     * Creates a new instance.
     */
    public IsdnChannelConfig() {
        super();
    }

    public int getMaxLogicalConnection() {
        return maxLogicalConnection;
    }

    public int getMaxBDataBlocks() {
        return maxBDataBlocks;
    }

    public int getMaxBDataLen() {
        return maxBDataLen;
    }

    public void setMaxLogicalConnection(int max) {
        this.maxLogicalConnection = max;
    }

    public void setMaxBDataBlocks(int max) {
        this.maxBDataBlocks = max;
    }

    public void setMaxBDataLen(int max) {
        this.maxBDataLen = max;
    }

    public CompatibilityInformationProfile getCompatibilityInformationProfile() {
        return compatibilityInformationProfile;
    }

    public void setCompatibilityInformationProfile(CompatibilityInformationProfile value) {
        this.compatibilityInformationProfile = value;
    }

    public B1Protocol getB1() {
        return b1;
    }

    public B2Protocol getB2() {
        return b2;
    }

    public B3Protocol getB3() {
        return b3;
    }

    public void setB1(B1Protocol protocol) {
        this.b1 = protocol;
    }

    public void setB2(B2Protocol protocol) {
        this.b2 = protocol;
    }

    public void setB3(B3Protocol protocol) {
        this.b3 = protocol;
    }

    public B1Configuration getB1Config() {
        return b1configuration;
    }

    public B2Configuration getB2Config() {
        return b2configuration;
    }

    public B3Configuration getB3Config() {
        return b3Configuration;
    }

    public void setB3Config(B3Configuration config) {
        this.b3Configuration = config;
    }

    public void setB2Config(B2Configuration b2Config) {
        this.b2configuration = b2Config;
    }

    public void setB1Config(B1Configuration b1Config) {
        this.b1configuration = b1Config;
    }

    public BChannelOperation getBChannelOperation() {
        return this.bChannelOperation;
    }

    public void setBChannelOperation(BChannelOperation oper) {
        this.bChannelOperation = oper;
    }

    public AdditionalInfo getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(AdditionalInfo info) {
        this.additionalInfo = info;
    }

    public BearerCapability getBearerCapability() {
        return bearerCapability;
    }

    public void setBearerCapability(BearerCapability bc) {
        this.bearerCapability = bc;
    }

    public LowLayerCompatibility getLowLayerCompatibility() {
        return lowLayerCompatibility;
    }

    public void setLowLayerCompatibility(LowLayerCompatibility llc) {
        this.lowLayerCompatibility = llc;
    }

    public HighLayerCompatibility getHighLayerCompatibility() {
        return highLayerCompatibility;
    }

    public void setHighLayerCompatibility(HighLayerCompatibility hlc) {
        this.highLayerCompatibility = hlc;
    }

    public void setPlci(PLCI plci) {
        this.plci = plci;
    }

    public PLCI getPlci() {
        return plci;
    }

    @Override
    public String toString() {
        return String.format("%s(plci = %s, b1 = %s, b2 = %s, b3 = %s)", getClass().getSimpleName(), plci, b1, b2, b3);
    }

    public short getLogicalChannelIdentifier() {
        return logicalChannelIdentifier;
    }

    public void setLogicalChannelIdentifier(short logicalChannelIdentifier) {
        this.logicalChannelIdentifier = logicalChannelIdentifier;
    }

    public boolean isDeliveryConfirmationEnabled() {
        return deliveryConfirmationEnabled;
    }

    public void setDeliveryConfirmationEnabled(boolean enabled) {
        this.deliveryConfirmationEnabled = enabled;
    }

    public FacilitiesSupport getFacilities() {
        return facilities;
    }

    public void setFacilities(FacilitiesSupport facilities) {
        this.facilities = facilities;
    }

    public NCCI getNcci() {
        return ncci;
    }

    public void setNcci(NCCI ncci) {
        this.ncci = ncci;
    }
    
    @Override
    public void setPipelineFactory(ChannelPipelineFactory pipelineFactory) {
        logger.trace("setPipelineFactory() :: {}", pipelineFactory);
        this.pipelineFactory = pipelineFactory;
    }

    @Override
    public ChannelPipelineFactory getPipelineFactory() {
        return pipelineFactory;
    }

}

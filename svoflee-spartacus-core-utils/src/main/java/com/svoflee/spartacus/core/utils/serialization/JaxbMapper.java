/*
 * Copyright (c) http://www.svoflee.com All rights reserved.
 **************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **************************************************************************      
 */

package com.svoflee.spartacus.core.utils.serialization;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.namespace.QName;

import org.apache.commons.lang3.StringUtils;

import com.svoflee.spartacus.core.utils.exception.EUtils;

/**
 * 使用Jaxb2.0实现XML<->Java Object的Mapper.
 * 在创建时需要设定所有需要序列化的Root对象的Class.
 * 特别支持Root对象是Collection的情形.
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public class JaxbMapper {

    // 多线程安全的Context.
    private JAXBContext jaxbContext;

    /**
     * @param rootTypes 所有需要序列化的Root对象的Class.
     */
    public JaxbMapper(Class<?>... rootTypes) {
        try {
            jaxbContext = JAXBContext.newInstance(rootTypes);
        }
        catch (JAXBException e) {
            throw EUtils.unchecked(e);
        }
    }

    /**
     * Java Object->Xml without encoding.
     */
    public String toXml(Object root) {
        return this.toXml(root, null);
    }

    /**
     * Java Object->Xml with encoding.
     */
    public String toXml(Object root, String encoding) {
        try {
            StringWriter writer = new StringWriter();
            createMarshaller(encoding).marshal(root, writer);
            return writer.toString();
        }
        catch (JAXBException e) {
            throw EUtils.unchecked(e);
        }
    }

    /**
     * Java Object->Xml without encoding, 特别支持Root Element是Collection的情形.
     */
    public String toXml(Collection<?> root, String rootName) {
        return this.toXml(root, rootName, null);
    }

    /**
     * Java Object->Xml with encoding, 特别支持Root Element是Collection的情形.
     */
    public String toXml(Collection<?> root, String rootName, String encoding) {
        try {
            CollectionWrapper wrapper = new CollectionWrapper();
            wrapper.collection = root;

            JAXBElement<CollectionWrapper> wrapperElement = new JAXBElement<CollectionWrapper>(new QName(rootName),
                    CollectionWrapper.class, wrapper);

            StringWriter writer = new StringWriter();
            createMarshaller(encoding).marshal(wrapperElement, writer);

            return writer.toString();
        }
        catch (JAXBException e) {
            throw EUtils.unchecked(e);
        }
    }

    /**
     * Xml->Java Object.
     */
    public <T> T fromXml(String xml) {
        try {
            StringReader reader = new StringReader(xml);
            return (T) createUnmarshaller().unmarshal(reader);
        }
        catch (JAXBException e) {
            throw EUtils.unchecked(e);
        }
    }

    /**
     * 创建Marshaller并设定encoding(可为null).
     */
    public Marshaller createMarshaller(String encoding) {
        try {
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            if (StringUtils.isNotBlank(encoding)) {
                marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
            }

            return marshaller;
        }
        catch (JAXBException e) {
            throw EUtils.unchecked(e);
        }
    }

    /**
     * 创建UnMarshaller.
     */
    public Unmarshaller createUnmarshaller() {
        try {
            return jaxbContext.createUnmarshaller();
        }
        catch (JAXBException e) {
            throw EUtils.unchecked(e);
        }
    }

    /**
     * 封装Root Element 是 Collection的情况.
     */
    public static class CollectionWrapper {

        @XmlAnyElement
        protected Collection<?> collection;
    }
}

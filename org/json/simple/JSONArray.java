/*
 * Decompiled with CFR 0.150.
 */
package org.json.simple;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.simple.JSONAware;
import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;

public class JSONArray
extends ArrayList
implements List,
JSONAware,
JSONStreamAware {
    private static final long serialVersionUID = 3957988303675231981L;

    public static void writeJSONString(List list, Writer out) throws IOException {
        if (list == null) {
            out.write("null");
            return;
        }
        boolean first = true;
        Iterator iter = list.iterator();
        out.write(91);
        while (iter.hasNext()) {
            if (first) {
                first = false;
            } else {
                out.write(44);
            }
            Object value = iter.next();
            if (value == null) {
                out.write("null");
                continue;
            }
            JSONValue.writeJSONString(value, out);
        }
        out.write(93);
    }

    public void writeJSONString(Writer out) throws IOException {
        JSONArray.writeJSONString(this, out);
    }

    public static String toJSONString(List list) {
        if (list == null) {
            return "null";
        }
        boolean first = true;
        StringBuffer sb = new StringBuffer();
        Iterator iter = list.iterator();
        sb.append('[');
        while (iter.hasNext()) {
            if (first) {
                first = false;
            } else {
                sb.append(',');
            }
            Object value = iter.next();
            if (value == null) {
                sb.append("null");
                continue;
            }
            sb.append(JSONValue.toJSONString(value));
        }
        sb.append(']');
        return sb.toString();
    }

    public String toJSONString() {
        return JSONArray.toJSONString(this);
    }

    public String toString() {
        return this.toJSONString();
    }
}


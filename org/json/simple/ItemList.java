/*
 * Decompiled with CFR 0.150.
 */
package org.json.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ItemList {
    private String sp = ",";
    List items = new ArrayList();

    public ItemList() {
    }

    public ItemList(String s) {
        this.split(s, this.sp, this.items);
    }

    public ItemList(String s, String sp) {
        this.sp = s;
        this.split(s, sp, this.items);
    }

    public ItemList(String s, String sp, boolean isMultiToken) {
        this.split(s, sp, this.items, isMultiToken);
    }

    public List getItems() {
        return this.items;
    }

    public String[] getArray() {
        return (String[])this.items.toArray();
    }

    public void split(String s, String sp, List append, boolean isMultiToken) {
        if (s == null || sp == null) {
            return;
        }
        if (isMultiToken) {
            StringTokenizer tokens = new StringTokenizer(s, sp);
            while (tokens.hasMoreTokens()) {
                append.add(tokens.nextToken().trim());
            }
        } else {
            this.split(s, sp, append);
        }
    }

    public void split(String s, String sp, List append) {
        if (s == null || sp == null) {
            return;
        }
        int pos = 0;
        int prevPos = 0;
        do {
            prevPos = pos;
            if ((pos = s.indexOf(sp, pos)) == -1) break;
            append.add(s.substring(prevPos, pos).trim());
        } while ((pos += sp.length()) != -1);
        append.add(s.substring(prevPos).trim());
    }

    public void setSP(String sp) {
        this.sp = sp;
    }

    public void add(int i2, String item) {
        if (item == null) {
            return;
        }
        this.items.add(i2, item.trim());
    }

    public void add(String item) {
        if (item == null) {
            return;
        }
        this.items.add(item.trim());
    }

    public void addAll(ItemList list) {
        this.items.addAll(list.items);
    }

    public void addAll(String s) {
        this.split(s, this.sp, this.items);
    }

    public void addAll(String s, String sp) {
        this.split(s, sp, this.items);
    }

    public void addAll(String s, String sp, boolean isMultiToken) {
        this.split(s, sp, this.items, isMultiToken);
    }

    public String get(int i2) {
        return (String)this.items.get(i2);
    }

    public int size() {
        return this.items.size();
    }

    public String toString() {
        return this.toString(this.sp);
    }

    public String toString(String sp) {
        StringBuffer sb = new StringBuffer();
        for (int i2 = 0; i2 < this.items.size(); ++i2) {
            if (i2 == 0) {
                sb.append(this.items.get(i2));
                continue;
            }
            sb.append(sp);
            sb.append(this.items.get(i2));
        }
        return sb.toString();
    }

    public void clear() {
        this.items.clear();
    }

    public void reset() {
        this.sp = ",";
        this.items.clear();
    }
}


/*******************************************************************************
 * Copyright (c) 2015 Andrey Loskutov. All rights reserved.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *     Andrey Loskutov - initial API and implementation
 *******************************************************************************/
package java5;

/**
 * @author nirav_000
 *
 */
import java.util.HashMap;
import java.util.Map;

public enum Status {
    PASSED(1, "Passed", "The test has passed."),
    FAILED(-1, "Failed", "The test was executed but failed."),
    DID_NOT_RUN(0, "Did not run", "The test did not start.");

    private int code;
    private String label;
    private String description;

    /**
     * A mapping between the integer code and its corresponding Status to facilitate lookup by code.
     */
    private static Map<Integer, Status> codeToStatusMapping;

    private Status(int code, String label, String description) {
        this.code = code;
        this.label = label;
        this.description = description;
    }

    public static Status getStatus(int i) {
        if (codeToStatusMapping == null) {
            initMapping();
        }
        return codeToStatusMapping.get(i);
    }

    private static void initMapping() {
        codeToStatusMapping = new HashMap<Integer, Status>();
        for (Status s : values()) {
            codeToStatusMapping.put(s.code, s);
        }
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Status");
        sb.append("{code=").append(code);
        sb.append(", label='").append(label).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(Status.PASSED);
        System.out.println(Status.getStatus(-1));
    }
}

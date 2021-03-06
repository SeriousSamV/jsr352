/*
 * Copyright (c) 2015 Red Hat, Inc. and/or its affiliates.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.jberet.testapps.javajsl;

import javax.batch.api.partition.AbstractPartitionReducer;
import javax.batch.runtime.context.StepContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class PartitionReducer1 extends AbstractPartitionReducer {
    @Inject
    private StepScopedBean stepScopedBean;

    @Inject
    private StepContext stepContext;

    @Override
    public void beforePartitionedStepCompletion() throws Exception {
        stepContext.setExitStatus(String.valueOf(stepScopedBean.getSequence().intValue()));
    }
}

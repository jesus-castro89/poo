package com.empresa.nomina.util;

import com.empresa.nomina.model.Position;

import java.util.Comparator;

public class PositionComparator {

    public static Comparator<Position> BY_RETENTION =
            Comparator.comparingDouble(Position::getRetentionPercentage);
}

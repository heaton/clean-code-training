package com.thoughtworks.troops.entity;

import com.thoughtworks.troops.Position;

public class Adult extends Member {

	public Adult(String name, int position) {
		super(name, position);
	}

    @Override
    public String toString() {
        String result = String.format("%s - Adult, Position = %s", getName(), Position.getDescriptionBy(getPosition()));
        return result;
    }

}

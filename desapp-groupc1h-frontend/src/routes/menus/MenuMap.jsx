import React, {useState} from 'react';
import {HEREMap, Marker} from "here-maps-react";
import {Button, Icon, Modal} from "antd";
import {useIntl} from "react-intl";

function MenuMap({item}) {
    const [visible, setVisible] = useState(false);
    const {formatMessage} = useIntl();

    const MenuMapLabel = () => {
        return <span> {`${item.name}, ${item.serviceLocation.address}, ${item.serviceLocation.city}`}
            <Icon type="environment" style={{color: "#FF8C00"}}/> </span>;
    };

    const onClick = () => {
        setVisible(true);
    };

    const onCancel = () => {
        setVisible(false);
    };

    return (
        <div>
            <Button size="large" style={{marginLeft: 15}} onClick={onClick}>
                {formatMessage({id: "location"})}
            </Button>
            <Modal
                title={<MenuMapLabel/>}
                visible={visible}
                onCancel={onCancel}
                destroyOnClose={true}
                footer={null}
                style={{top: 20}}
                bodyStyle={{height: "450px"}}
            >
                <HEREMap
                    appId="B3ZYLI1mKHNO6Qt871t6"
                    appCode="xibhrih8Kcvp0bcijbEBqA"
                    center={{lat: item.serviceLocation.latitude, lng: item.serviceLocation.longitude}}
                    zoom={15}
                    interactive={true}
                >
                    <Marker
                        lat={item.serviceLocation.latitude}
                        lng={item.serviceLocation.longitude}
                        draggable={false}
                    />
                </HEREMap>
            </Modal>
        </div>
    )
}

export default MenuMap;
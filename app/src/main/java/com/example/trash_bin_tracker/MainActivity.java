package com.example.trash_bin_tracker;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.InputStream;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // 엑셀 파일 읽기
        try {
            InputStream is = getAssets().open("trash_bin_info.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            Iterator<Row> rowIterator = workbook.getSheetAt(0).iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getRowNum() == 0) continue;  // 헤더 행 건너뛰기
                double lat = row.getCell(1).getNumericCellValue();
                double lng = row.getCell(2).getNumericCellValue();
                String type = row.getCell(3).getStringCellValue();

                LatLng location = new LatLng(lat, lng);
                mMap.addMarker(new MarkerOptions()
                        .position(location)
                        .title(type)
                        .icon(type.equals("일반") ?
                                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED) :
                                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                        .draggable(true));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.5665, 126.9780), 12f));

        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {
                // 드래그 시작 시 호출
            }

            @Override
            public void onMarkerDrag(Marker marker) {
                // 드래그 중일 때 호출
            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                LatLng position = marker.getPosition();
                // 새로운 위치 저장 로직 추가
                // 주소, 위도, 경도 업데이트
            }
        });
    }
}
